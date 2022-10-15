<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> <jsp:include page="/Header.jsp" />
	<jsp:include page="/contact.jsp" />
</head>
<body>
<style>

	.wrap {
		display: flex;
		justify-content: space-around;
	}


	.row {
		display: flex;
		flex-wrap: wrap;
	}

	* {
		box-sizing: border-box;
	}
	.product-item {
		width: 300px;
		text-align: center;
		margin: 0 auto;
		border-bottom: 2px solid #F5F5F5;
		background: white;
		font-family: "Open Sans";
		transition: .3s ease-in;
	}
	.product-item:hover {
		border-bottom: 2px solid #fc5a5a;
	}
	.product-item img {
		display: block;
		width: 100%;
	}
	.product-list {
		background: #fafafa;
		padding: 15px 0;
	}
	.product-list h3 {
		font-size: 18px;
		font-weight: 400;
		color: #444444;
		margin: 0 0 10px 0;
	}
	.price {
		font-size: 16px;
		color: #fc5a5a;
		display: block;
		margin-bottom: 12px;
	}
	.button {
		text-decoration: none;
		display: inline-block;
		padding: 0 12px;
		background: #cccccc;
		color: white;
		text-transform: uppercase;
		font-size: 12px;
		line-height: 28px;
		transition: .3s ease-in;
	}
	.product-item:hover .button {
		background: #fc5a5a;
	}


</style>

<div class="wrap">

	<div class="product-item">

		<img src="/views/M.jpg">
		<div class="product-list">
			<h3>Fan M Series ⌀100</h3>
			<span class="price">₽ 1546</span>
			<a href="/Cart/add?model=100 M" class="button">Add to cart</a>
		</div>

		<img src="/views/VKO.jpg">
		<div class="product-list">
			<h3>Fan VKO Series ⌀100</h3>
			<span class="price">₽ 1239</span>
			<a href="" class="button">Add to cart</a>
		</div>

		<img src="/views/M3.jpg">
		<div class="product-list">
			<h3>Fan M3 Series ⌀100</h3>
			<span class="price">₽ 2548</span>
			<a href="" class="button">Add to cart</a>
		</div>
	</div>

	<div class="product-item">

		<img src="/views/M.jpg">
		<div class="product-list">
			<h3>Fan M Series ⌀125</h3>
			<span class="price">₽ 1905</span>
			<a href="" class="button">Add to cart</a>
		</div>

		<img src="/views/VKO.jpg">
		<div class="product-list">
			<h3>Fan VKO Series ⌀125</h3>
			<span class="price">₽ 1438</span>
			<a href="" class="button">Add to cart</a>
		</div>

		<img src="/views/M3.jpg">
		<div class="product-list">
			<h3>Fan M3 Series ⌀125</h3>
			<span class="price">₽ 3034</span>
			<a href="" class="button">Add to cart</a>
		</div>
	</div>

	<div class="product-item">

		<img src="/views/M.jpg">
		<div class="product-list">
			<h3>Fan M Series ⌀150</h3>
			<span class="price">₽ 3119</span>
			<a href="" class="button">Add to cart</a>
		</div>

		<img src="/views/VKO.jpg">
		<div class="product-list">
			<h3>Fan VKO Series ⌀150</h3>
			<span class="price">₽ 2007</span>
			<a href="" class="button">Add to cart</a>
		</div>

		<img src="/views/M3.jpg">
		<div class="product-list">
			<h3>Fan M3 Series ⌀150</h3>
			<span class="price">₽ 4392</span>
			<a href="" class="button">Add to cart</a>
		</div>
	</div>




</div>
</body>
</html>