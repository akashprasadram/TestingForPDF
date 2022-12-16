package com.akash.spring_junit_test_app.user.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGenerator1 {
    public void generateItierary(String filePath) {
        System.out.println("Inside generateItierary()");
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            document.add(generateTable1());
            document.add(generateTable2());
            document.add(generateTable3());
            document.add(generateTable4());
            document.close();
        } catch (FileNotFoundException | DocumentException e) {
            System.out.println("Exception in generateItinerary " + e);
        }
        finally{
            System.out.println("Exist generateItierary()");
        }
    }
    private PdfPTable generateTable4() {

        PdfPTable table = new PdfPTable(8);
        PdfPCell cell;
        Font font = new Font();
        font.setSize(4);
        font.setStyle("bold");

        cell = new PdfPCell(new Phrase(" ", font));
        cell.setColspan(8);
        cell.setBorder(0);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Total Installments : ", font));
        cell.setColspan(1);
        cell.setBorder(7);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("2", font));
        cell.setColspan(1);
        cell.setBorder(3);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Total Paid : ", font));
        cell.setColspan(1);
        cell.setBorder(3);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("3000", font));
        cell.setColspan(1);
        cell.setBorder(3);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Due Amount : ", font));
        cell.setColspan(1);
        cell.setBorder(3);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("27000", font));
        cell.setColspan(1);
        cell.setBorder(3);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Installment paid in break:", font));
        cell.setColspan(1);
        cell.setBorder(3);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("0", font));
        cell.setColspan(1);
        cell.setBorder(11);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        return table;
    }
    private PdfPTable generateTable3() {
        PdfPTable table = new PdfPTable(7);
        PdfPCell cell;
        Font font = new Font();
        font.setSize(5);
        font.setStyle("bold");
        

        cell = new PdfPCell(new Phrase("Serial. No.", font));
        cell.setColspan(1);
        cell.setRowspan(2);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Due Date", font));
        cell.setColspan(1);
        cell.setRowspan(2);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Installment Amount", font));
        cell.setColspan(1);
        cell.setRowspan(2);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Recieved Amount", font));
        cell.setColspan(2);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Outstanding Amount", font));
        cell.setColspan(1);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Remarks", font));
        cell.setColspan(1);
        cell.setRowspan(2);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Recieved date", font));
        cell.setColspan(1);
        cell.setRowspan(1);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Total", font));
        cell.setColspan(1);
        cell.setRowspan(1);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Due Amount", font));
        cell.setColspan(1);
        cell.setRowspan(1);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        
        table=generaterow(table,24);

        return table;
    }

    PdfPTable generaterow(PdfPTable table,int n)
    {
        PdfPCell cell;
        Font font = new Font();
        font.setSize(6);
        int borderValue=12;
        for(int i=1;i<=n;i++)
        {
            if(i==n)
            {
                borderValue=14;
            }
            cell = new PdfPCell(new Phrase(""+i, font));
            cell.setColspan(1);
            cell.setBorder(borderValue);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("19/12/2022", font));
            cell.setColspan(1);
            cell.setBorder(borderValue);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("1500", font));
            cell.setColspan(1);
            cell.setBorder(borderValue);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(" 19/12/2022", font));
            cell.setColspan(1);
            cell.setBorder(borderValue);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("1500", font));
            cell.setColspan(1);
            cell.setBorder(borderValue);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("28500", font));
            cell.setColspan(1);
            cell.setBorder(borderValue);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("", font));
            cell.setColspan(1);
            cell.setBorder(borderValue);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }
        return table;
    }
    private PdfPTable generateTable2() {
        PdfPTable table = new PdfPTable(5);
        PdfPCell cell;
        Font font1 = new Font();
        font1.setSize(6);
        font1.setStyle("bold");
        Font font = new Font();
        font.setSize(6);

        cell = new PdfPCell(new Phrase("Disbursement No : ", font1));
        cell.setColspan(1);
        cell.setBorder(5);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("LON001", font));
        cell.setColspan(1);
        cell.setBorder(1);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(" ", font));
        cell.setColspan(1);
        cell.setBorder(1);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Total loan Amount :	", font1));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setColspan(1);
        cell.setBorder(1);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("30000", font));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setColspan(1);
        cell.setBorder(9);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Disbursement Date : ", font1));
        cell.setColspan(1);
        cell.setBorder(4);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("12/12/2022", font));
        cell.setColspan(1);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(" ", font));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Product Name : ", font1));
        cell.setColspan(1);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("LOAN", font));
        cell.setColspan(1);
        cell.setBorder(8);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Member Name : ", font1));
        cell.setColspan(1);
        cell.setBorder(4);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Rakesh Tiwary", font));
        cell.setColspan(1);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(" ", font));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Installment : ", font1));
        cell.setColspan(1);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("1500", font));
        cell.setColspan(1);
        cell.setBorder(8);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Centre Name : ", font1));
        cell.setColspan(1);
        cell.setBorder(4);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("ASTHA MM", font));
        cell.setColspan(1);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(" ", font));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Down Payment : ", font1));
        cell.setColspan(1);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("0", font));
        cell.setColspan(1);
        cell.setBorder(8);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Centre Address : ", font1));
        cell.setColspan(1);
        cell.setBorder(4);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Bagunhatu", font));
        cell.setColspan(1);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(" ", font));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Outstanding amount : ", font1));
        cell.setColspan(1);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("30000", font));
        cell.setColspan(1);
        cell.setBorder(8);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Spouse Name : ", font1));
        cell.setColspan(1);
        cell.setBorder(4);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("NA", font));
        cell.setColspan(1);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(" ", font));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Disb. Day :	", font1));
        cell.setColspan(1);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Saturday", font));
        cell.setColspan(1);
        cell.setBorder(8);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Expected Disb. Date : ", font1));
        cell.setColspan(1);
        cell.setBorder(4);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("12/12/2022", font));
        cell.setColspan(1);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(" ", font));
        cell.setColspan(5);
        cell.setBorder(8);
        table.addCell(cell);
        /*cell = new PdfPCell(new Phrase("Expected Disb. Date : ", font1));
        cell.setColspan(1);
        cell.setBorder(6);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_TOP);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("12/12/2022", font));
        cell.setColspan(1);
        cell.setBorder(2);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_TOP);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(" ", font));
        cell.setColspan(3);
        cell.setBorder(10);
        table.addCell(cell);*/

        cell = new PdfPCell(new Phrase(" ", font1));
        cell.setColspan(7);
        cell.setBorder(14);
        table.addCell(cell);
        return table;
    }
    private PdfPTable generateTable1() {
        PdfPTable table = new PdfPTable(7);
        PdfPCell cell;

        Font headerfont1 =new Font() ; 
        headerfont1.setSize(10);
        headerfont1.setStyle("bold"); 
        
        Font headerfont =new Font() ; 
        headerfont.setSize(10);

        cell = new PdfPCell(new Phrase("MAA ENTERPRISES",headerfont1));
        cell.setColspan(7);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("VIDYAPATI NAGAR, NEAR ULTA SHIV MANDIR & PATEL CLUB",headerfont));
        cell.setColspan(7);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(0);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("JAMSHEDPUR, JHARKHAND",headerfont));
        cell.setColspan(7);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(0);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(" "));
        cell.setColspan(7);
        cell.setBorder(0);
        table.addCell(cell);

        Font font1 = new Font();
        font1.setSize(8);
        font1.setStyle("bold");
        Font font = new Font();
        font.setSize(8);


        cell = new PdfPCell(new Phrase("Branch : ", font1));
        cell.setColspan(1);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("001-Sidhgora", font));
        cell.setColspan(1);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Party Ledger", font1));
        cell.setColspan(2);
        cell.setBorder(0);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Installment Type :", font1));
        cell.setColspan(2);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Weekly", font));
        cell.setColspan(1);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(" ", font));
        cell.setColspan(7);
        cell.setBorder(0);
        table.addCell(cell);

        return table;
    }
}
