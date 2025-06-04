document.getElementById("openPdf").addEventListener("click", () => {
    chrome.runtime.sendMessage({ action: "openPdf" }, response => {
      if (chrome.runtime.lastError) {
        alert("背景腳本錯誤：" + chrome.runtime.lastError.message);
        return;
      }
      if (!response.ok) {
        alert("尚未攔截到 PDF 請求，請先刷新網頁一次！");
      }
    });
  });
  