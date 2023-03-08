package cl.phobos.superheroessearch.ads

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
fun BannerAds(){
    AndroidView(factory = {
        AdView(it).apply {
            adSize = AdSize.BANNER
            adUnitId= "ca-app-pub-5699913438320950/3620842313"
            loadAd(AdRequest.Builder().build())

        }
    })
}
