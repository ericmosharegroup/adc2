package com.xiaopeng;

public class demoTest {
	public static void main(String[] args) {
		String aa = "<form name=\"punchout_form\" method=\"post\" action=\"https://openapi.alipay.com/gateway.do?charset=utf-8&method=alipay.trade.page.pay&sign=YJzhEn5dYa8DYWDYRHUj5%2BNdROLKNQo7NJzcDDkNEKIIjEXGDZ7ZJC3bfb0ZB6sMDXgXdvtWHKSZKN8Ez%2FhFS2KPE6s55pOOgl3LkJvEdCnWmI9IZbfCkvNx74T5vZ%2FNpxcdTHnaixSC4O2xFHJZW0JRg9y2cSeQD4ee8%2FseBs%2BteEYChwYIaJyXLO%2BnwDaZ6TGLqXvP1W1MBwC7R%2FQFxY%2FTZWIVnbhNl%2Ff4DsA2aLEKIiIAopiV7a9yy35j8TLrqXTUhmxyNrrHXCub07OfXHMhPnHPU%2Ffg7I295H73pdcXEJZujdDP2V64V2cNI0s0qSmArQlmUrBFTKS1zwl32w%3D%3D&return_url=1d70d665a07f0279a834f2824eb8e6e9b3ceaffa&notify_url=http%3A%2F%2Fia7cnt.natappfree.cc%2F1%2Fali%2Fpay%2Fnotify&version=1.0&app_id=2018030502321647&sign_type=RSA2&timestamp=2018-05-17+16%3A39%3A43&alipay_sdk=alipay-sdk-java-dynamicVersionNo&format=json\">\n<input type=\"hidden\" name=\"biz_content\" value=\"{&quot;disable_pay_channels&quot;:&quot;credit_group&quot;,&quot;out_trade_no&quot;:&quot;xp20180517163943b40a4fdd03a64706&quot;,&quot;product_code&quot;:&quot;FAST_INSTANT_TRADE_PAY&quot;,&quot;subject&quot;:&quot;nba&quot;,&quot;timeout_express&quot;:&quot;60m&quot;,&quot;total_amount&quot;:&quot;0.01&quot;}\">\n<input type=\"submit\" value=\"立即支付\" style=\"display:none\" >\n</form>\n<script>document.forms[0].submit();</script>";
		System.out.println(aa);
	}
}
