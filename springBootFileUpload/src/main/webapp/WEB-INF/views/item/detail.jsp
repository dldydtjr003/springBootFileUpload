<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T1 Community | Mission Detail</title>
<style>
:root {
	--t1-red: #E2012D;
	--t1-black: #0f0f0f;
	--t1-gray: #1a1a1a;
	--t1-light-gray: #252525;
	--t1-gold: #C69C6D;
}

body {
	background-color: var(--t1-black);
	font-family: 'Pretendard', -apple-system, sans-serif;
	color: #ffffff;
	margin: 0;
	padding: 80px 0;
	display: flex;
	justify-content: center;
}

.detail-container {
	width: 900px;
	background: var(--t1-gray);
	border: 1px solid rgba(226, 1, 45, 0.3);
	border-radius: 20px;
	box-shadow: 0 20px 50px rgba(0, 0, 0, 0.5);
	overflow: hidden;
}

/* 상단 섹션: 이미지 + 정보 레이아웃 */
.main-info-section {
	display: flex;
	padding: 40px;
	gap: 40px;
	border-bottom: 1px solid #333;
}

/* 이미지 영역 */
.image-area {
	flex: 1;
	display: flex;
	justify-content: center;
	align-items: center;
}

.image-area img {
	width: 100%;
	max-width: 350px;
	border-radius: 12px;
	box-shadow: 0 10px 30px rgba(0, 0, 0, 0.4);
	border: 1px solid #333;
	transition: transform 0.3s ease;
}

.image-area img:hover {
	transform: scale(1.02);
}

/* 텍스트 정보 영역 */
.info-area {
	flex: 1.2;
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.post-no {
	color: var(--t1-red);
	font-weight: 800;
	font-size: 0.85rem;
	letter-spacing: 1px;
	text-transform: uppercase;
	margin-bottom: 8px;
}

.info-area h1 {
	margin: 0 0 20px 0;
	font-size: 2.2rem;
	font-weight: 700;
	color: #fff;
	line-height: 1.2;
}

.price-box {
	background: var(--t1-light-gray);
	padding: 20px;
	border-radius: 10px;
	border-left: 4px solid var(--t1-gold);
}

.price-label {
	display: block;
	font-size: 0.8rem;
	color: #888;
	margin-bottom: 5px;
	text-transform: uppercase;
}

.price-value {
	font-size: 1.8rem;
	color: var(--t1-gold);
	font-weight: 800;
}

/* 하단 버튼 영역 */
.btn-area {
	padding: 25px 40px;
	background: #111;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.btn {
	padding: 12px 28px;
	font-weight: 700;
	border-radius: 8px;
	text-decoration: none;
	transition: all 0.2s ease;
	font-size: 0.95rem;
	display: inline-block;
}

.btn-list {
	background: transparent;
	color: #aaa;
	border: 1px solid #444;
}

.btn-list:hover {
	background: #333;
	color: #fff;
}

.btn-group {
	display: flex;
	gap: 12px;
}

.btn-edit {
	background: var(--t1-red);
	color: #fff;
}

.btn-cancel {
	background: #333;
	color: #ccc;
}

.btn:hover {
	transform: translateY(-3px);
	box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
}

.btn-edit:hover {
	background: #ff0033;
}

/* 푸터 데코 */
.footer-deco {
	padding: 20px;
	text-align: center;
	font-size: 0.7rem;
	color: #444;
	background: #0a0a0a;
	letter-spacing: 2px;
	border-top: 1px solid #1a1a1a;
}
</style>
</head>
<body>

	<div class="detail-container">
		<div class="main-info-section">
			<div class="image-area">
				<img alt="상품이미지 ${item.name}" src="/item/display?id=${item.id}">
			</div>
			
			<div class="info-area">
				<span class="post-no">PRODUCT ID: ${item.id}</span>
				<h1>${item.name}</h1>
				
				<div class="price-box">
					<span class="price-label">LIST PRICE</span>
					<span class="price-value">$ ${item.price}</span>
				</div>
			</div>
		</div>

		<div class="btn-area">
			<a href="/item/itemList" class="btn btn-list">← 상품목록 리스트</a>

			<div class="btn-group">
				<a href="/item/updateForm?id=${item.id}" class="btn btn-edit">상품 수정하기</a> 
				<a href="/item/delete?id=${item.id}" class="btn btn-cancel">상품 삭제하기</a>
			</div>
		</div>

		<div class="footer-deco">[ SYSTEM: T1 COMMUNITY SECURE TERMINAL v2.6 ]</div>
	</div>

</body>
</html>