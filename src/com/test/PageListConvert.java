//package com.test;
//
///**
// * @Author create by  huarong
// * @Date ${Date} ${Time}
//        */
//
//import com.github.pagehelper.PageInfo;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PageListConvert {
//    public PageListConvert() {
//    }
//
//    public static <T> PageInfo<T> convertListToPage(List<T> list, Integer pageNum, Integer pageSize) {
//        PageInfo<T> pageInfo = new PageInfo();
//        int total = 0;
//        int pages = 0;
//        pageNum = pageNum != null ? pageNum : 1;
//        pageSize = pageSize != null ? pageSize : 10;
//        if (list != null) {
//            total = list.size();
//        }
//
//        if (list != null && list.size() > 0 && list.size() % pageSize == 0) {
//            pages = list.size() / pageSize;
//        } else if (list != null) {
//            pages = list.size() / pageSize + 1;
//        }
//
//        List<T> pageList = new ArrayList();
//        if (list != null && pageNum * pageSize <= list.size()) {
//            pageList.addAll(list.subList((pageNum - 1) * pageSize, pageNum * pageSize));
//        } else if (list != null && (pageNum - 1) * pageSize < list.size() && pageNum * pageSize > list.size()) {
//            pageList.addAll(list.subList((pageNum - 1) * pageSize, list.size()));
//        }
//
//        pageInfo.setPageNum(pageNum);
//        pageInfo.setPageSize(pageSize);
//        pageInfo.setTotal((long)total);
//        pageInfo.setPages(pages);
//        pageInfo.setList(pageList);
//        return pageInfo;
//    }
//}
//
