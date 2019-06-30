// dev
const config = {
  protocol: 'http://',
  picpath: 'http://10.128.134.149/'
  // picpath: 'http://10.129.0.189/'
}

if (typeof module !== 'undefined' && typeof module.exports !== 'undefined') {
  module.exports = config
} else {
  window.config = config
}
