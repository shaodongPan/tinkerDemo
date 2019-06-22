# tinkerDemo
demo 微信热修复框架学习 

一些坑点

1.app要添加一定要signingConfigs信息，并有keystore文件

2.步骤是首先进行assemble打包，然后build文件夹下面会有定义出来的bakApk文件夹，里面有打包出来的apk文件，这是old apk包

3.修复bug后，然后用tinker assemble 打包会得到一个带签名信息的patch_signed_7zip.apk包

4.到tinker网站上，发布对应版本的patch信息
