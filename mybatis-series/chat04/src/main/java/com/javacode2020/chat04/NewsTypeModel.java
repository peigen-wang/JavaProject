package com.javacode2020.chat04;

import java.util.List;

public class NewsTypeModel {
    private int typeId;
    private String typeName;
    private String typeCode;

    /**
     * 分类下对应的news集合
     */
    private List<NewsModel> newsModelList;
}
