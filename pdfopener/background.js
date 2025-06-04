let lastPdfUrl = null;

chrome.webRequest.onCompleted.addListener(
  details => {
    if (details.url.includes("getPDF.php?id=")) {
      lastPdfUrl = details.url;
      console.log("捕捉到 PDF URL:", lastPdfUrl);
    }
  },
  { urls: ["<all_urls>"] }
);

chrome.runtime.onMessage.addListener((msg, sender, sendResponse) => {
  if (msg.action === "openPdf") {
    if (lastPdfUrl) {
      chrome.tabs.create({ url: lastPdfUrl });
      sendResponse({ ok: true });
    } else {
      sendResponse({ ok: false });
    }
  }
  return true; 
});
