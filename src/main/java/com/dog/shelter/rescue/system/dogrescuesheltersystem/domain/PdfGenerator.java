package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.AreaBreakType;
import com.itextpdf.layout.property.UnitValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.property.TextAlignment;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Objects;
@Slf4j
@Service
public class PdfGenerator {

    public byte[] generatePdf(Map<String, Object> formData, PotentialAdopter potentialAdopter, Customer customer) throws FileNotFoundException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        Paragraph title = new Paragraph("Application Form")
                .setTextAlignment(TextAlignment.CENTER)
                .setBold()
                .setFontSize(20);
        document.add(title);

        document.add(new Paragraph("\n"));
        addCustomerPdf(document, customer);
        document.add(new Paragraph("\n"));
        addApplicationPdf(document, formData);


        if (potentialAdopter != null){

            addPotentialAdopterPdf(document, potentialAdopter);
        }

        document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));

        document.close();


        return baos.toByteArray();



}
    public void addApplicationPdf(Document document, Map<String, Object> formData){

        document.add(new Paragraph("- Form Information").setBold().setFontSize(14));

        // 日期格式转换器
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        // 定义内容排版顺序
        Map<String, String> orderedKeys = new LinkedHashMap<>();
        orderedKeys.put("id", "Form ID");
        orderedKeys.put("adopter_id", "Adopter ID");
        orderedKeys.put("dog_id", "Dog ID");
        orderedKeys.put("status", "Status");
        orderedKeys.put("interview_date", "Interview Date");
        orderedKeys.put("created_date", "Created Date");
        // Reason will be added last

        // 遍历orderedKeys来保证内容的排版顺序
        orderedKeys.forEach((key, displayName) -> {
            Object value = formData.get(key);
            String formattedValue = value != null ? value.toString() : "";
            // 特殊处理日期格式
            if (("created_date".equals(key) || "interview_date".equals(key)) && value != null) {
                LocalDateTime date = LocalDateTime.parse(formattedValue, inputFormatter);
                formattedValue = date.format(outputFormatter);
            }
            if ("interview_date".equals(key) && value == null) {
                formattedValue = "To be confirmed";
            }
            Paragraph paragraph = new Paragraph()
                    .add(new Text(displayName + ": ").setBold())
                    .add(formattedValue)
                    .setFontSize(12);
            document.add(paragraph);
        });

        // 单独处理reason字段
        String reason = (String) formData.get("reason");
        Paragraph reasonParagraph = new Paragraph()
                .add(new Text("Reason: ").setBold())
                .add(reason != null ? reason : "")
                .setFontSize(12);
        document.add(reasonParagraph);


    }
    public void addPotentialAdopterPdf(Document document, PotentialAdopter potentialAdopter){

        Map<String, String[]> categories = new LinkedHashMap<>();
        categories.put("- Family Members", new String[]{"householdMembers", "children", "otherPets", "family_photo"});
        categories.put("- Residence", new String[]{"housingType", "housingStability", "landlordConsent", "landlordContact", "living_room", "balcony", "kitchen", "garden"});
        categories.put("- Personal Background", new String[]{"incomeLevel", "workStudySchedule", "petInsurance", "previousPetOwnership"});
        categories.put("- Dog Care Planning and Willingness", new String[]{"petCareKnowledge", "dailyActivities", "adoptionPurpose", "petPreference", "preparation", "emergencyPlan"});
        categories.put("- Reference and Commitment", new String[]{"referencePerson", "postAdoptionSupportCommitment", "agreementCompliance"});

        categories.forEach((categoryName, fields) -> {
            // 为每个分类添加一个新的页面
            document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));

            // 添加分类标题
            document.add(new Paragraph(categoryName).setBold().setFontSize(14));

            for (String field : fields) {
                try {
                    Field reflectField = potentialAdopter.getClass().getDeclaredField(field);
                    reflectField.setAccessible(true);
                    Object value = reflectField.get(potentialAdopter);
                    if (value != null) {
                        String displayName = formatFieldName(field);


                        if ("family_photo".equals(field) || "living_room".equals(field) || "balcony".equals(field) || "kitchen".equals(field) || "garden".equals(field)) {
                            String imageUrl = value.toString();
                            ImageData imageData = ImageDataFactory.create(imageUrl);
                            Image image = new Image(imageData);
                            image.scaleToFit(450, 450);

                            if ("family_photo".equals(field)) {
                                document.add(new Paragraph(displayName + ":").setBold().setFontSize(12));
                                document.add(image);
                                document.add(new Paragraph("\n"));
                            } else {

                                document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
                                document.add(new Paragraph(displayName + ":").setBold().setFontSize(12));
                                document.add(image);

                            }
                        } else {

                            String formattedValue = value.toString();

                            if (value instanceof Boolean) {
                                formattedValue = (Boolean) value ? "Yes" : "No";
                            }
                            Paragraph paragraph = new Paragraph()
                                    .add(new Text(displayName + ": ").setBold())
                                    .add(formattedValue)
                                    .setFontSize(12);
                            document.add(paragraph);
                        }
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                } catch (java.io.IOException e) {
                    e.printStackTrace();

                    System.err.println("Error loading image: " + e.getMessage());
                }
            }



        });

    }

    public void addCustomerPdf(Document document, Customer customer){

        document.add(new Paragraph("- Customer Information").setBold().setFontSize(14));

        Map<String, String> customerFields = new LinkedHashMap<>();
        customerFields.put("firstName", "First Name");
        customerFields.put("middleName", "Middle Name");
        customerFields.put("lastName", "Last Name");
        customerFields.put("gender", "Gender");
        customerFields.put("age", "Age");
        customerFields.put("phoneNumber", "Phone Number");
        customerFields.put("email", "Email");

        customerFields.forEach((field, displayName) -> {
            try {
                Field reflectField = customer.getClass().getDeclaredField(field);
                reflectField.setAccessible(true);
                Object value = reflectField.get(customer);
                String formattedValue = value != null ? value.toString() : "N/A";

                // 特殊处理布尔字段为Yes/No
                if (value instanceof Boolean) {
                    formattedValue = (Boolean) value ? "Yes" : "No";
                }

                Paragraph paragraph = new Paragraph()
                        .add(new Text(displayName + ": ").setBold())
                        .add(formattedValue)
                        .setFontSize(12);
                document.add(paragraph);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });



    }

    private String formatFieldName(String fieldName) {
        // 将下划线替换为空格，并将每个单词的首字母大写
        String[] parts = fieldName.split("_");
        StringBuilder formattedName = new StringBuilder();
        for (String part : parts) {
            if (formattedName.length() > 0) formattedName.append(" ");
            formattedName.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
        }
        return formattedName.toString();
    }


}
