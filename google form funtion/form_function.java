function modifyVideoInFourthSection() {
  var form = FormApp.getActiveForm();
  var items = form.getItems();
  var pageBreakCount = 0;
  var targetVideoItem = null;
  

  for (var i = 0; i < items.length; i++) {
    var itemType = items[i].getType();
    
    if (itemType === FormApp.ItemType.PAGE_BREAK) {
      pageBreakCount++;
      continue;
    }
    

    if (pageBreakCount === 3 && targetVideoItem === null) {
      if (itemType === FormApp.ItemType.VIDEO) {
        targetVideoItem = items[i];
        break;
      }
    }
  }
  
  if (targetVideoItem !== null) {

    var randomVideos = [
    { title: "青花瓷", videoId: "uf8HHCcbpFc" },
    { title: "本草綱目", videoId: "x2xe4--N72Q" },
    ];
    
    var randomIndex = Math.floor(Math.random() * randomVideos.length);
    var selectedVideo = randomVideos[randomIndex];
    

    var videoItem = targetVideoItem.asVideoItem();
    videoItem.setTitle(selectedVideo.title);
    videoItem.setVideoUrl("https://www.youtube.com/watch?v=" + selectedVideo.videoId);
    
    Logger.log("已修改第4區段的影片項目為：" + selectedVideo.title);
  } else {
    Logger.log("找不到第4區段的影片項目");
  }
}
