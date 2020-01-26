var account = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-login').on('click', function () {
            _this.login();
        });
   },
    save : function () {
        var data = {
            id: $('#id').val(),
            password: $('#password').val(),
            name: $('#name').val()
        };

        $.ajax({
            type: 'POST',
            url: '/signup',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원가입 완료');
            window.location.href = '/login';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    login : function () {
        var data = {
            id: $('#id').val(),
            password: $('#password').val()
        };

        $.ajax({
            type: 'POST',
            url: '/login',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('로그인 성공');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

account.init();