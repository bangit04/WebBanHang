package vn.bang.WebBanHang.controller.response;

import java.io.Serializable;

public abstract class PageResponseAbstract implements Serializable {
    public int pageNumber;
    public int pageSize;
    public long totalElements;
    public long totalPages;

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }
}
