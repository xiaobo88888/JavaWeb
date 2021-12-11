<%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/11/11
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--分页开始--%>
<div id="page_nav">
    <%--如果是第一页，则不显示首页和上一页--%>
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>

    <%--页码输出的开始--%>
    <c:choose>
        <%--情况一：如果总页码小于等于五，则页码范围是 1 - 总页码 --%>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
        </c:when>
        <%--情况二：如果总页码大于五--%>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <%--如果当前页码是前三页，则页码范围是1- 5--%>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:set var="begin" value="1"></c:set>
                    <c:set var="end" value="5"></c:set>
                </c:when>
                <%--如果当前页码时后三页，则页码范围是 总页码-4 - 总页码--%>
                <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal - 3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal - 4}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
                </c:when>
                <%--其他情况时，页码范围就是：当前页码-2 - 当前页码+2--%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo - 2}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageNo + 2}"></c:set>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <%--页码输出的结束--%>

    <c:forEach begin="${begin}" end="${end}" var="i">
        <%--如果是当前页码则不准点击--%>
        <c:if test="${requestScope.page.pageNo == i}">
            [${i}]
        </c:if>
        <%--如果不是当前页码，则可以点击--%>
        <c:if test="${requestScope.page.pageNo != i}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>

    <%--如果已经是最后一页了，则不显示下一页--%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>

    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input id = "searchPageBtn" type="button" value="确定">
</div>

<%--为跳转按钮绑定单机事件--%>
<script type="text/javascript">
    $(function (){
        $("#searchPageBtn").click(function (){
            var pageNo = $("#pn_input").val();

            var pageTotal = ${requestScope.page.pageTotal};

            if(pageNo >= 1 && pageNo <= pageTotal){
                location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo=" + pageNo;
            }else{
                alert("请输入正确的页码，第【" + pageNo + "】页不存在");
            }
            /*JavaScript语言提供了一个location地址栏对象
            他有一个属性叫href，他可以获取浏览器地址栏中的地址
            href属性可读可写，类似于跳转到href制定的地址上*/

        });
    });
</script>
