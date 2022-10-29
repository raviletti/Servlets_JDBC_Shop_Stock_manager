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
        border: 2px solid black;
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
    #shading {
        background: rgba(102, 102, 102, 0.5);
        width: 100%;
        height: 100%;
        position: absolute;
        top: 0;
        left: 0;
        display: none;
    }
    #window {
        width: 200px;
        height: 160px;
        text-align: center;
        padding: 15px;
        border: 3px solid black;
        border-radius: 10px;
        color: black;
        position: absolute;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
        margin: auto;
        background: white;
    }
    #shading:target {display: block;}
</style>


<div class="wrap">
    <div class="product-item">

        <img src="https://vents-rus.ru/image/data/data/448_b.jpg">
        <div class="product-list">
            <h3>Fan M Series ⌀100</h3>
            <span class="price">₽ 1546</span>
            <a href="#shading" class="button">Add to cart</a>
        </div>
    </div>



<div id="shading">
    <div id="window">
        100 M <p>
        <form action="/Cart" method="POST">
            <p>
                <label for="count">Count: </label>
                <input type="number" step="1" min="1" max="10000" value="1" id="count" name="count"/>
                <input type="hidden" name="model" value="100 M" />
        <p>
        <button type="submit" class="btn btn-outline-dark">Add</button>
        <a class="btn btn-outline-dark" href="#" role="button">Cancel</a>
    </form>
    </div>
</div>
</div>
</body>
</html>