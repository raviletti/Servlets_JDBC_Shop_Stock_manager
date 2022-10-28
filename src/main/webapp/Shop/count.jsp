<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Название документа</title>
    <style>
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
            height: 100px;
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
        .close {
            display: inline-block;
            border: 1px solid #0000cc;
            color: black;
            padding: 0 12px;
            margin: 10px;
            text-decoration: none;
            background: #f2f2f2;
            font-size: 14pt;
            cursor:pointer;
        }
        .close:hover {background: #e6e6ff;}

        .button {
            text-decoration: none;
            display: inline-block;
            padding: 0 12px;
            background: white;
            color: black;
            text-transform: uppercase;
            font-size: 12px;
            line-height: 28px;
            transition: .3s ease-in;
        }


    </style>
</head>

<body>

<div id="shading">
    <div id="window">
        100 M <p>
        <form>
            <p>
                <label for="count">Count: </label>
                <input type="number" step="1" min="1" max="10000" value="1" id="count" name="count"/>

            <p>
                <button type="submit"class="button">Add</button>


        </form>


    </div>
</div>

<a href="#shading">Add to cart</a>

</body>
</html>
