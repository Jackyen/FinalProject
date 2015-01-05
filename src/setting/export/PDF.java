package setting.export;

// Setting Hotkey �ǥX�@��char
import java.io.*;
import java.util.ArrayList;

import project.java2014.Bernie.PicContainer;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;

public class PDF {
	// ���ͤ���r��
	private static Font fontBlackSmallCN;

	// ���ͦr��,�r��j�p
	private static final Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN,
			18, Font.BOLD);

	// Ū����r��
	private static String inputFile = "C:/Users/user/Desktop/JAVA/JAVA Project/javatest/memo0.txt";
	private static int counter = 0;
	// ���ͤ@��A4�j�p��PDF�ɮ�
	private static Document document = new Document(PageSize.A4);

	public PDF(ArrayList<PicContainer> pics, SettingParameter setting)
			throws DocumentException {

		try {
			// ���ͤ���r��,�r��j�p
			BaseFont bfChinese = BaseFont.createFont("MHei-Medium",
					"UniCNS-UCS2-H", BaseFont.NOT_EMBEDDED);
			fontBlackSmallCN = new Font(bfChinese, 12, Font.BOLD,
					new BaseColor(0, 0, 0));

			// �Ndocument��J���w���|
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(setting.getPath() + "/test2.pdf"));
			document.open();

			for (PicContainer pic : pics) {
				Image image = Image.getInstance(pic.getPicture().toString());
				image.setAlignment(Element.ALIGN_CENTER);

				// filedata���paragraph�����h
				Paragraph paragraph = new Paragraph(pic.getComment(),
						fontBlackSmallCN);
				paragraph.setAlignment(Element.ALIGN_CENTER);

				// �g�Jdocument��
				document.add(image);
				document.add(addEmptyLine(paragraph, 3));
			}

			// PDF ��󤺮e����
			addMetaDataTitle(document);
			document.close();

			/*
			 * for ( ; counter < 3; counter++) { // �NŪ�i�Ӫ��ɮש�JinputStream��
			 * inputFile =
			 * "C:\\Users\\user\\Desktop\\JAVA\\JAVA Project\\javatest\\memo" +
			 * counter + ".txt"; FileReader inputStream = new
			 * FileReader(inputFile);
			 * 
			 * // �C��Ū���@��byte��Jfiledata String filedata = ""; while
			 * (inputStream.ready()) { int word = inputStream.read(); filedata
			 * += (char) word; }
			 * 
			 * 
			 * 
			 * 
			 * // Ū��image�ɮ� inputFile =
			 * "C:/Users/user/Desktop/JAVA/JAVA Project/javatest/" + counter +
			 * ".png"; Image image = Image.getInstance (inputFile);
			 * image.setAlignment(Element.ALIGN_CENTER);
			 * 
			 * // filedata���paragraph�����h Paragraph paragraph = new
			 * Paragraph(filedata, fontBlackSmallCN);
			 * paragraph.setAlignment(Element.ALIGN_CENTER);
			 * 
			 * // �g�Jdocument�� document.add(image);
			 * document.add(addEmptyLine(paragraph, 3)); }
			 * 
			 * // PDF ��󤺮e���� addMetaDataTitle(document); document.close();
			 */

			/*
			 * Anchor anchor = new Anchor("���D�@", fontRedCN);
			 * anchor.setName("First Chapter");
			 * 
			 * Chapter catPart = new Chapter(new Paragraph(anchor), 1);
			 * Paragraph subPara = new Paragraph("Subcategory 1", subFont);
			 * 
			 * Section subCatPart = catPart.addSection(subPara);
			 * subCatPart.add(new Paragraph(filedata));
			 * 
			 * Paragraph paragraph = new Paragraph(filedata);
			 * subCatPart.add(paragraph); document.add(paragraph);
			 */
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ��󤺮e����
	 * 
	 * @param document
	 */
	private static void addMetaDataTitle(Document document) {
		// �W�[���D
		document.addTitle("�I�ϧg");
		// �W�[�@��
		document.addAuthor("�ĤE�ջs�@");
		// �W�[�إ�PDF�ɶ��H�έק�PDF���
		document.addCreationDate();
		// �W�[PDF��������r
		document.addKeywords("�Ʊ氪��~~");
		// �W�[PDF���D�D
		document.addSubject("���");
	}

	/**
	 * ����
	 */
	private static Paragraph addEmptyLine(Paragraph paragraph, int number) {
		if (number != 0)
			for (int i = 0; i < number; i++)
				paragraph.add(new Paragraph(" "));
		return paragraph;
	}

	/**
	 * �W�[�ť�
	 */
	private static String addBlank(int blank) {
		StringBuilder bu = new StringBuilder();
		if (blank > 0)
			for (int i = 0; i <= blank; i++)
				bu.append(" ");
		return bu.toString();
	}
}