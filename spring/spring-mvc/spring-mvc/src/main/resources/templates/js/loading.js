let loaded_if = false;

$(document).ready(function () {
  setTimeout(() => {
    $("#loading_controller_main_id").addClass("stop_loader");
    loaded_if = true;
    $("#loading_controller_main_id").css({
      opacity: 0,
      zIndex: -1,
    });
  }, 1000);
});

let box = document.querySelector("#container_loader_id");
let selections = document.querySelector(
  ".selection_panel_secondary_container > *.selection_panel_secondary_container_selection"
);
console.log(selections);

selections.addEventListener("clicked", (e) => {
  console.log("s");
});

let boxBoundingRect = box.getBoundingClientRect();
let boxCenter = {
  x: boxBoundingRect.left + boxBoundingRect.width / 2,
  y: boxBoundingRect.top + boxBoundingRect.height / 2,
};

document.addEventListener("mousemove", (e) => {
  if (loaded_if == true) {
    // Do some codes :)
  } else {
    let angle =
      Math.atan2(e.pageX - boxCenter.x, -(e.pageY - boxCenter.y)) *
      (180 / Math.PI);
    // if (angle < 90 || angle < -90) {
    box.style.transform = `rotate(${angle}deg)`;
    // }
  }
});
