function articleDelete() {
        $(function () {
            $("tr").on("click", function () {
                var tr = $(this);
                var articleId = tr.children(".ajaxListItemId").text();
                $.ajax("/api/removeArticle", {
                    dataType: "json", //Тип данных ожидается ответа сервера.
                    type: "POST",
                    contentType: "application/json", //Тип содержимого используется при передаче данных на сервер
                    data: JSON.stringify(articleId), //Передаем на сервер
                    success: function (result) {
                        if (result) tr.remove();
                    }
                });

            });
        });
}

function articleAdd() {
    // $('#title').text("Ok");

    var data = {
        id: $("#valueNewArticleId").val(),
        name: $("#valueNewArticleName").val()
    };

    $.ajax( "/api/addArticle", {
        dataType: "json", //Тип данных ожидается ответа сервера.
        type: "POST",
        contentType: "application/json", //Тип содержимого используется при передаче данных на сервер
        data: JSON.stringify(data), //Передаем на сервер
        success: addArticleResult //Метод принимает
    });
}

function addArticleResult(forecastData) {
    $("#ajaxList").append("" +
        "<tr>" +
        "<td>" + forecastData.id + "</td>" +
        "<td>" + forecastData.name + "</td>" +
        "<td class=\"text-right\"><button class=\"btn btn-primary\" onclick=\"articleDelete()\">Delete</button></td>" +
        "</tr>");
}

