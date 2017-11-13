package com.core.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


@SuppressWarnings("deprecation")
public class CommonExcelUtil {
	static CommonExcelUtil commonExcelUtil = new CommonExcelUtil();


	/**
	 * 文件处理，和原文件相对路径保持一致，分别存到error，right，errorName文件夹内
	 */
	public static void dealError(List<Object[]> errors, String module,
			String wgCode, File excelFile, String pathType) {
		try {
			if (errors.size() > 0) {
				InputStream inForOut = new FileInputStream(excelFile);
				Workbook wbForOut = create(inForOut);
				String outFilePath = excelFile.getPath().replace("add",
						"error/" + pathType);
				File file = new File(outFilePath);
				File parentFile = file.getParentFile();
				if (!parentFile.exists()) {
					parentFile.mkdirs();
				}
				FileOutputStream out = new FileOutputStream(outFilePath);
				Sheet sheetForOut = wbForOut.getSheetAt(0);
				int last = sheetForOut.getLastRowNum();
				int first = 5;
				// 删除原数据
				for (int i = first; i <= last; i++) {
					Row row = sheetForOut.getRow(i);
					if (row != null) {
						sheetForOut.removeRow(row);
					}
				}
				// 添加错误数据
				for (int i = 0; i < errors.size(); ++i) {
					Object[] dataArray = errors.get(i);
					Row row = sheetForOut.createRow(i + 5);
					for (int j = 0; j < dataArray.length; ++j) {
						if (dataArray[j] != null) {
							String value = String.valueOf(dataArray[j]);
							row.createCell(j).setCellValue(value);
						}
					}
				}
				// 另存为目标文件
				wbForOut.write(out);
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static Workbook create(InputStream in) throws IOException,
			InvalidFormatException {
		if (!in.markSupported()) {
			in = new PushbackInputStream(in, 8);
		}
		if (POIFSFileSystem.hasPOIFSHeader(in)) {
			return new HSSFWorkbook(in);
		}
		if (POIXMLDocument.hasOOXMLHeader(in)) {
			return new XSSFWorkbook(OPCPackage.open(in));
		}
		throw new IllegalArgumentException("你的excel版本目前poi解析不了");
	}

	/**
	 * 
	 * @param file
	 *            文件
	 * @param startline
	 *            开始读取行数
	 * @return
	 * @throws InvalidFormatException
	 *             文件错误 poi未支持
	 * @throws IOException
	 *             文件读取错误
	 */

	public static List<Object[]> getDataFromExcel(File file, int startline) {
		List<Object[]> arraylist = new ArrayList<Object[]>();
		try {
			FileInputStream inputstream = new FileInputStream(file);
			Workbook xssfWorkbook = create(inputstream);
			// for (int i = 0; i < 1; i++) {
			// 只读第一个Sheet
			Sheet xssfSheet = xssfWorkbook.getSheetAt(0);
			for (int j = 0; j < xssfSheet.getPhysicalNumberOfRows(); j++)
				if (j >= startline) {
					Row hssfrow = xssfSheet.getRow(j);
					if (hssfrow == null) {
						break;
					}
					short word0 = hssfrow.getLastCellNum();
					if (word0 < 0)
						continue;
					Object aobj[] = new Object[word0];
					for (int k = 0; k < word0; k++) {
						Cell xssfCell = hssfrow.getCell((short) k);
						if (xssfCell != null)
							switch (xssfCell.getCellType()) {
							case HSSFCell.CELL_TYPE_NUMERIC: // '\0'
								double d = xssfCell.getNumericCellValue();
								if (HSSFDateUtil.isCellDateFormatted(xssfCell)) {
									aobj[k] = new java.sql.Date(
											(HSSFDateUtil.getJavaDate(d))
													.getTime());
								} else {
									long l = Double.valueOf(d).longValue();
									if (l == d)
										aobj[k] = (new StringBuffer(
												String.valueOf(l)))
												.toString();
									else
										aobj[k] = new BigDecimal(""+d).longValue();
								}
								break;
							case HSSFCell.CELL_TYPE_STRING: // '\001'
								aobj[k] = xssfCell.getStringCellValue();
								break;
							case HSSFCell.CELL_TYPE_FORMULA: // '\002'
								aobj[k] = xssfCell.getCellFormula();
								break;
							case HSSFCell.CELL_TYPE_BLANK: // '\003'
								aobj[k] = null;
								break;
							case HSSFCell.CELL_TYPE_BOOLEAN: // '\004'
								aobj[k] = new Boolean(
										xssfCell.getBooleanCellValue());
								break;
							case HSSFCell.CELL_TYPE_ERROR: // '\005'
								aobj[k] = new Byte(xssfCell.getErrorCellValue());
								break;
							default:
								aobj[k] = null;
								break;
							}
						else
							aobj[k] = null;
					}
					arraylist.add(aobj);
				}
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arraylist;
	}
}
