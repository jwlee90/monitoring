<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jspf"%>
</head>
<body>
	<div id="wrap">

		<!--header-->
		<div id="header1">
			<div class="logo">
				<h1>
					<a href="#"><img src="/images/moniteringlogo.png" alt="logo">
						Monitering Service</a>
				</h1>
			</div>
			<div class="gnb">
				<!--[D]해당메뉴 활성화시 li class="on" 적용-->
				<ul>
					<li><a href="#">메인</a></li>
					<li><a href="#">이벤트</a></li>
					<li><a href="#">관리자</a></li>
					<li class="on"><a href="#">서비스</a></li>
					<li><a href="#">설정</a></li>
					<li><a href="#">코드관리</a></li>
				</ul>
				<p class="logout">
					<span>ABCD님 (마스터관리자)</span> <a href="#"><img
						src="common/images/btn_logout.gif" alt="로그아웃"></a>
				</p>
			</div>
		</div>
		<!--header//-->

		<hr />

		<!--container-->
		<div id="container">
			<!--lnb메뉴-->
			<div class="content full">
				<!--[D] h3 타이틀 아래 텍스트가 없을 경우 <h3 class="no_line"> 적용-->
				<h3 class="no_line">서비스 관리</h3>
				<a class="btn_print" href="#"><span>인쇄</span></a>

				<div class="table_info">
					<p class="table_txt">
						전체 <strong>${fn:length(serviceList)}</strong> 건
					</p>
					<div class="btn">
						<a href="#" class="btn_st03"><span>등록</span></a> <a href="#"
							class="btn_st02"><span>삭제</span></a>
					</div>
				</div>

				<div class="table_lst">
					<!--[D] 테이블이 길 경우 table style="width:px"값 설정 style="width:1250px" -->
					<table class="table_st01" summary="서비스 등록 관리 리스트">
						<caption>관리자계정관리 리스트</caption>
						<colgroup>
							<col width="*">
							<col width="*">
							<col width="*">
							<col width="*">
							<col width="*">
							<col width="*">
						</colgroup>
						<thead>
							<tr>
								<th></th>
								<th>서비스명</th>
								<th>API명</th>
								<th>check API</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${fn:length(serviceList) > 0}">
									<c:forEach items="${serviceList }" var="row">
										<tr>
											<td><input type="checkbox"></td>
											<td>${row.service_name }</td>
											<td>${row.api_name }</td>
											<td>${row.check_api }</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="4">조회된 결과가 없습니다.</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>

				<!--페이징-->
				<div class="paging">
					<div class="p_num">
						<a href="#"><span class="pre_end_n">처음</span></a> <a href="#"><span
							class="pre_n">이전</span></a> <a href="#" class="on">1</a><a href="#">2</a><a
							href="#">3</a><a href="#">4</a><a href="#">5</a><a href="#">6</a><a
							href="#">7</a><a href="#">8</a><a href="#">9</a><a href="#">10</a>
						<a href="#"><span class="next_n">다음</span></a> <a href="#"><span
							class="next_end_n">마지막</span></a>
					</div>
				</div>
				<!-- //페이징-->
			</div>
		</div>
		<!--container//-->

		<!--footer-->
		<div id="footer">
			<div class="footer">
				<p class="f_logo">
					<img src="common/images/f_logo.gif" alt="">
				</p>
				<p class="copyright"></p>
			</div>
		</div>
		<!--footer//-->
		
	</div>
</body>
</html>