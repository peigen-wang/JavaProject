package com.javacode2020.chat04;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author peigen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsModel {

    private int id;
    private int typeId;
    private String typeCode;
    private String title;
    private String subTitle;
    private String description;
    private String imageUrl;

}
