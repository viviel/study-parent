function setSign(c) {
    $('#sign').html(JSON.stringify(c, null, 2));
}

function setContent(c) {
    $('#content').html(c);
}

function appendContent(c) {
    let $content = $('#content');
    const content = $content.html();
    $content.html(content + JSON.stringify(c, null, 2) + '<br><br>');
}

function addEvent() {
    socket.on('connect', function () {
        setSign('connect');
    });

    socket.on('disconnect', function () {
        setSign('disconnect');
    });

    socket.on('connect_error', function (data) {
        setSign(data);
    });

    socket.on('connectData', function (data) {
        appendContent(data);
    });

    socket.on('message', function (data) {
        appendContent(data);
    });
}

function test() {
    appendContent('test');
}

function sendMsg() {
    let time = parseInt(new Date().getTime() / 1000);
    let msg = {
        "msg_type": 1,
        "id": 'messageId-' + time,
        "role": 1,
        "action": 0,
        "sender_name": "vv",
        "msg": "弹幕test",
        "time": time
    };
    socket.emit('message', msg, function (data) {
        appendContent(data);
    });
}
