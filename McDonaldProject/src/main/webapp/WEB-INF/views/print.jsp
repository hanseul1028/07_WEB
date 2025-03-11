<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//String brand = (String)request.getAttribute("brand");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요게 이제 굉장히 중요함</title>
</head>
<body>

	<br/>
	
	${ brand } <br/>
	${ bestSeller }	
	
	<!-- 
		bestSeller.brand 라는 방식으로 필드에 직접 접근이 가능한 이유
		EL에서 자동으로 필드명으로 접근해 getter 를 불러서 가지고옴.
	 -->
	<ul>
		<li>
			브랜드 : ${ bestSeller.brand }
		</li>
		<li>
			버거 : ${ bestSeller.name }
		</li>
		<li>
			가격 : ${ bestSeller.price }
		</li>
	</ul>
	
	두 개 이상의 Scope에 같은 키값으로 값을 담은 경우 <br>
	
	<!--
		범위가 작은 애를 먼저 출력 
		page => request => session => application 순으로 키값을 검색
	 -->
	 Scope에 직접 접근하는 방법! <br>
	 
	 requestScope : ${ requestScope.brand } <br>
	 sessionScope : ${ sessionScope.brand } <br>
	 
	 만약에 없는 키값 el 구문으로 출력하려고 하면 어떻게 될까? <br><br>
	 
	 없는 값 : ${ sessionScope.abc }
	 
	 빈 문자열 나옴 끝. => 에러가 안난다.
	 
	 <hr>
	 
	 연산은 어디서 하는게 제일 좋을까?
	 => 1. SQL 문(DB단에서 하는게 좋음)
	 	2. Java => Service단(validation / transaction 처리)
	 	3. View 에서는 되도록 작업을 안하는 게 좋음
	 	=> 하지만~ 100퍼센트 맞는건 아니다.
	 	
	 <hr>
	 
	 <h3>1. 산술연산</h3>
	 
	 <p>
	 	* EL 구문을 이용한 산술연산
	 	
	 	big + small = ${ big + small } <br>
	 	big - small = ${ big - small } <br>
	 	big X small = ${ big * small } <br>
	 	big % small = ${ big / small } 또는 ${ big div small } <br>
	 	big % small = ${ big % small } 또는 ${ big mod small } <br>
	 
	 </p>
	 
	 <h3>2. 논리연산</h3>
	 
	 <p>
	 
	 	AND : ${ true && true } 또는 ${ true and true } <br>
	 	OR  : ${ true || true } 또는 ${ true or true } <br>
	 </p>
	 
	 
	 비교연산 == 조건식으로 많이 사용
	 
	 <h4>숫자끼리 비교해볼까?</h3>
	 
	 <p>
	 	big이 small 보다 작니? : ${ big < small } 또는 ${ big lt small } <br>
	 	big이 small 보다 크니? : ${ big > small } 또는 ${ big gt small } <br>
	 	big이 small 보다 작거나 같니? : ${ big le small } <br>
	 	big이 small 보다 크거나 같니? : ${ big ge small } <br>
	 </p>
	 
	 <br>
	 
	 <h4>동등비교도 해볼까?</h4>
	 
	 <p>
	 	big 이 small과 같습니까? : ${ big == small } 또는 ${ big eq small }  <br>
	 	big 이 10과 같습니까? : ${ big eq 10 } <br>
	 	str과 좋아하는 문구가 일치합니까? : ${ str == "테슬라 폭락" } 또는 ${ str eq "테슬라 폭락" } <br>
	 	big이 10과 일치하지 않습니까? ${ big ne 10 } <br>
	 </p>
	 
	 <h4>비어있는지 체크</h4>
	 
	 <p>
	 	bestSeller가 null과 일치합니까? <br> 
	 	${ bestSeller eq null} <br>
	 	또는 ${ bestSeller == null } <br>
	 	또는 ${ empty bestSeller } <br>
	 	
	 	list가 비어있지 않습니까?  <br>
	 	${ !empty list } <br>
	 </p>
	
	
</body>
</html>