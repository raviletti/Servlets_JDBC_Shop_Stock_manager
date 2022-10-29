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
			<form id="100M" action="/Cart" method="POST">
				<p>
					<label for="count">Count: </label>
					<input type="number" step="1" min="1" max="10000" value="1" id="count" name="count"/>
					<input type="hidden" name="model" value="100 M" />
				<p>
					<button type="submit" class="button">Add to cart</button>
			</form>
		</div>

		<img src="/views/VKO.jpg">
		<div class="product-list">
			<h3>Fan VKO Series ⌀100</h3>
			<span class="price">₽ 1239</span>
			<form id="100VKO" action="/Cart" method="POST">
				<p>
					<label for="count">Count: </label>
					<input type="number" step="1" min="1" max="10000" value="1" id="count" name="count"/>
					<input type="hidden" name="model" value="100 VKO" />
				<p>
					<button type="submit" class="button">Add to cart</button>
			</form>
		</div>

		<img src="/views/M3.jpg">
		<div class="product-list">
			<h3>Fan M3 Series ⌀100</h3>
			<span class="price">₽ 2548</span>
			<form id="100M3" action="/Cart" method="POST">
				<p>
					<label for="count">Count: </label>
					<input type="number" step="1" min="1" max="10000" value="1" id="count" name="count"/>
					<input type="hidden" name="model" value="100 M3" />
				<p>
					<button type="submit" class="button">Add to cart</button>
			</form>
		</div>
	</div>

	<div class="product-item">

		<img src="/views/M.jpg">
		<div class="product-list">
			<h3>Fan M Series ⌀125</h3>
			<span class="price">₽ 1905</span>
			<form id="125M" action="/Cart" method="POST">
				<p>
					<label for="count">Count: </label>
					<input type="number" step="1" min="1" max="10000" value="1" id="count" name="count"/>
					<input type="hidden" name="model" value="125 M" />
				<p>
					<button type="submit" class="button">Add to cart</button>
			</form>
		</div>

		<img src="/views/VKO.jpg">
		<div class="product-list">
			<h3>Fan VKO Series ⌀125</h3>
			<span class="price">₽ 1438</span>
			<form id="125VKO" action="/Cart" method="POST">
				<p>
					<label for="count">Count: </label>
					<input type="number" step="1" min="1" max="10000" value="1" id="count" name="count"/>
					<input type="hidden" name="model" value="125 VKO" />
				<p>
					<button type="submit" class="button">Add to cart</button>
			</form>
		</div>

		<img src="/views/M3.jpg">
		<div class="product-list">
			<h3>Fan M3 Series ⌀125</h3>
			<span class="price">₽ 3034</span>
			<form id="125M3" action="/Cart" method="POST">
				<p>
					<label for="count">Count: </label>
					<input type="number" step="1" min="1" max="10000" value="1" id="count" name="count"/>
					<input type="hidden" name="model" value="125 M3" />
				<p>
					<button type="submit" class="button">Add to cart</button>
			</form>
		</div>
	</div>

	<div class="product-item">

		<img src="/views/M.jpg">
		<div class="product-list">
			<h3>Fan M Series ⌀150</h3>
			<span class="price">₽ 3119</span>
			<form id="150M" action="/Cart" method="POST">
				<p>
					<label for="count">Count: </label>
					<input type="number" step="1" min="1" max="10000" value="1" id="count" name="count"/>
					<input type="hidden" name="model" value="150 M" />
				<p>
					<button type="submit" class="button">Add to cart</button>
			</form>
		</div>

		<img src="/views/VKO.jpg">
		<div class="product-list">
			<h3>Fan VKO Series ⌀150</h3>
			<span class="price">₽ 2007</span>
			<form id="150VKO" action="/Cart" method="POST">
				<p>
					<label for="count">Count: </label>
					<input type="number" step="1" min="1" max="10000" value="1" id="count" name="count"/>
					<input type="hidden" name="model" value="150 VKO" />
				<p>
					<button type="submit" class="button">Add to cart</button>
			</form>
		</div>

		<img src="/views/M3.jpg">
		<div class="product-list">
			<h3>Fan M3 Series ⌀150</h3>
			<span class="price">₽ 4392</span>
			<form id="150M3" action="/Cart" method="POST">
				<p>
					<label for="count">Count: </label>
					<input type="number" step="1" min="1" max="10000" value="1" id="count" name="count"/>
					<input type="hidden" name="model" value="150 M3" />
				<p>
					<button type="submit" class="button">Add to cart</button>
			</form>
		</div>
	</div>




</div>
</body>
</html>