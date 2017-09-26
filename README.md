# RotateTextView
旋转90度 textView rotate
最近碰到一个签名区的需求：要求文字横屏显示，大致效果如下：
![](https://raw.githubusercontent.com/2227056071/imges/master/rotateTextView_1.png)

一开始想着这不是很简单:只要把系统自带 TextView 旋转 90 度就可以了。自己试了试，效果是实现了，可是碰到了一个问题:旋转后 View 在布局中所占据的宽度并没有改变，导致旋转后 view 上方出现了一段空白。在 github 上面搜了几个项目发现都没有考虑这个问题。那就索性自己撸一个出来。

思路如下：
#### 1.在测量方法 onMeasure() 中改变控件宽高：
  setMeasuredDimension(mHeight,mWidth);
#### 2.在绘制方法 onDraw() 中改变Canvas坐标系，使文字在竖直方向绘制，绘制文字时借助 StaticLayout 使文字能够自动换行。
