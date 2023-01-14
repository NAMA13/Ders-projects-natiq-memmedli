let condition = false;

let x = 0;
let y = 0;

let width_shadow = 15;
let height_shadow = 15;

let b_x = 0;
let b_y = 0;

let overDiv = false;

$(document).mousemove(function (e) {
  $("#cursor_shadow_Id").css({
    marginLeft: e.clientX - width_shadow / 2,
    marginTop: e.clientY - height_shadow / 2,
  });
  x = e.clientX;
  y = e.clienty;
  condition = true;
  showShadow();
});

let alwaysMouse = setInterval(check, 300);

function check() {
  if (b_x == x && b_y == y) {
    condition = false;
    hideShadow();
  } else if (b_x != x && b_y != y) {
    fadeShadow();
  }
  b_x = x;
  b_y = y;
}

function fadeShadow() {
  if (condition == true) {
    $("#cursor_shadow_Id").css({
      opacity: 0.5,
    });
  }
}

function showShadow() {
  if (condition == true) {
    $("#cursor_shadow_Id").css({
      opacity: 1,
      transform: "scale(1)",
    });
    if (overDiv == false) {
      $("#cursor_shadow_Id").css({
        filter: "blur(10px)",
      });
    }
  } else {
    if (overDiv == true) {
      $("#cursor_shadow_Id").css({
        filter: "blur(10px)",
      });
    }
  }
}
function hideShadow() {
  if (condition == false) {
    setInterval(() => {
      $("#cursor_shadow_Id").css({
        opacity: 0,
        transform: "scale(0.5)",
      });
    }, 2000);
  }
}

$("div").mouseover(function (e) {
  console.log("Width:" + width_shadow);
  console.log("Height:" + height_shadow);
  console.log("filter:" + "blur(25px)");
  divOvers(e);
  overDiv = true;
});

function divOvers(e) {
  if (e.currentTarget.id != "cursor_shadow_Id") {
    if (condition == true) {
      width_shadow = 50;
      height_shadow = 50;
      $("#cursor_shadow_Id").css({
        opacity: 1,
        width: width_shadow + "px",
        height: height_shadow + "px",
        backgroundColor: "black",
        filter: "blur(25px)",
      });
    }
  }
}
function divLeave(e) {
  if (e.currentTarget.id != "cursor_shadow_Id") {
    if (condition == true) {
      width_shadow = 15;
      height_shadow = 15;
      $("#cursor_shadow_Id").css({
        opacity: 1,
        width: width_shadow + "px",
        height: height_shadow + "px",
        filter: "blur(10px)",
        backgroundColor: "#27282a98",
      });
    }
  }
}

$("div").mouseleave(function (e) {
  console.log("Width:" + width_shadow);
  console.log("Height:" + height_shadow);
  console.log("filter:" + "blur(25px)");
  divLeave(e);
  overDiv = false;
});
