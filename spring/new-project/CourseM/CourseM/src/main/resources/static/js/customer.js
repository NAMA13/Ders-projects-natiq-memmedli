window.addEventListener("click", function (e) {
  if (
    document.getElementById("right_bottom_panel_twice_id").contains(e.target)
  ) {
    $("#right_bottom_panel_twice_id").addClass("active");
  } else {
    $("#right_bottom_panel_twice_id").removeClass("active");
  }
});

$("#main_search_id").focus(function () {
  $("#right_bottom_panel_twice_id").addClass("focus");
});
$("#main_search_id").focusout(function () {
    $("#right_bottom_panel_twice_id").removeClass("focus");
  });
  