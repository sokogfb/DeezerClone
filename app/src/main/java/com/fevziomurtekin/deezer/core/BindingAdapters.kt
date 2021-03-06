package com.fevziomurtekin.deezer.core

import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.fevziomurtekin.deezer.data.albumdetails.AlbumData
import com.fevziomurtekin.deezer.data.artist.ArtistData
import com.fevziomurtekin.deezer.data.artistdetails.ArtistAlbumData
import com.fevziomurtekin.deezer.data.artistdetails.ArtistRelatedData
import com.fevziomurtekin.deezer.data.genre.Data
import com.fevziomurtekin.deezer.data.search.SearchData
import com.fevziomurtekin.deezer.data.search.SearchQuery
import com.fevziomurtekin.deezer.ui.album.AlbumDetailsAdapter
import com.fevziomurtekin.deezer.ui.artist.ArtistAdapter
import com.fevziomurtekin.deezer.ui.artistdetails.albums.ArtistAlbumAdapter
import com.fevziomurtekin.deezer.ui.artistdetails.related.ArtistRelatedAdapter
import com.fevziomurtekin.deezer.ui.favorites.FavoritesAdapter
import com.fevziomurtekin.deezer.ui.genre.GenreAdapter
import com.fevziomurtekin.deezer.ui.search.RecentSearchAdapter
import com.fevziomurtekin.deezer.ui.search.SearchAlbumAdapter
import com.google.android.material.tabs.TabLayout
import timber.log.Timber

/**
 * Help in the development of this class, the application named 'Pokedex' @Skydoves user has helped.
 * https://github.com/skydoves/Pokedex/blob/master/app/src/main/java/com/skydoves/pokedex/binding/RecyclerViewBinding.kt
 * */

@BindingAdapter("adapter")
fun bindAdapter(view:RecyclerView, adapter:RecyclerView.Adapter<*>){
    view.adapter = adapter
}

@BindingAdapter("adapterGenreList")
fun bindingGenreList(view:RecyclerView, results:LiveData<Result<Any>>) {
    when (results.value) {
        Result.Loading, Result.Error -> {/* Nothing */
        }
        is Result.Succes -> {
            Timber.d("result : succes isSplash : false")
            (view.adapter as GenreAdapter).addGenreList(((results.value) as Result.Succes<List<Data>>).data)
        }
    }
}

@BindingAdapter("adapterArtistList")
fun bindingArtistList(view:RecyclerView, results:LiveData<Result<Any>>) {
    when (results.value) {
        Result.Loading, Result.Error -> {/* Nothing */
        }
        is Result.Succes -> {
            Timber.d("result : succes isSplash : false")
            (view.adapter as ArtistAdapter).addArtistList(((results.value) as Result.Succes<List<ArtistData>>).data)
        }
    }
}

@BindingAdapter("adapterTablayout")
fun bindingTabLayoutAdapter(view:TabLayout,viewPager: ViewPager){
    view.setupWithViewPager(viewPager)
}

@BindingAdapter("adapterViewPager")
fun bindingViewPagerAdapter(view:ViewPager,adapter:FragmentPagerAdapter){
    view.adapter = adapter
}


@BindingAdapter("adapterAAlbumsList")
fun bindingAAlbumsList(view:RecyclerView, results:LiveData<Result<Any>>) {
    when (results.value) {
        Result.Loading, Result.Error -> {/* Nothing */
        }
        is Result.Succes -> {
            Timber.d("result : succes isSplash : false")
            (view.adapter as ArtistAlbumAdapter).addAlbumList(((results.value) as Result.Succes<List<ArtistAlbumData>>).data)
        }
    }
}

@BindingAdapter("adapterARelatedList")
fun bindingARelatedList(view:RecyclerView, results:LiveData<Result<Any>>) {
    when (results.value) {
        Result.Loading, Result.Error -> {/* Nothing */
        }
        is Result.Succes -> {
            Timber.d("result : succes isSplash : false")
            (view.adapter as ArtistRelatedAdapter).addRelatedList(((results.value) as Result.Succes<List<ArtistRelatedData>>).data)
        }
    }
}

@BindingAdapter("adapterAlbumTracksList")
fun bindingAlbumTracksList(view:RecyclerView, results:LiveData<Result<Any>>) {
    when (results.value) {
        Result.Loading, Result.Error -> {/* Nothing */
        }
        is Result.Succes -> {
            Timber.d("result : succes isSplash : false")
            (view.adapter as AlbumDetailsAdapter).addAlbumTracks(((results.value) as Result.Succes<List<AlbumData>>).data)
        }
    }
}

@BindingAdapter("adapterRecentSearch")
fun bindingRecentSeach(view:RecyclerView, results:LiveData<List<SearchQuery>>) {
    Timber.d("binding recentData : ${results.value}")
    if(!results.value.isNullOrEmpty()) {
        (view.adapter as RecentSearchAdapter).addRecentSearch(((results.value) as List<SearchQuery>))
    }
}

@BindingAdapter("adapterSearchAlbum")
fun bindingSearchAlbum(view:RecyclerView, results:LiveData<Result<Any>>) {
    when (results.value) {
        Result.Loading, Result.Error -> {/* Nothing */
        }
        is Result.Succes -> {
            Timber.d("adapterSearchAlbum")
            (view.adapter as SearchAlbumAdapter).addAlbumSearch(((results.value) as Result.Succes<List<SearchData>>).data)
        }
    }
}

@BindingAdapter("onEditorActionListener")
fun bindOnEditorActionListener(editText: EditText, editorActionListener: TextView.OnEditorActionListener) {
    editText.setOnEditorActionListener(editorActionListener)
}

@BindingAdapter("adapterFavoritesList")
fun bindingFavoritesList(view:RecyclerView, results:LiveData<List<AlbumData>>) {
    if (!results.value.isNullOrEmpty()) {
        Timber.d("Favorites result :${results.value} ")
        (view.adapter as FavoritesAdapter).addFavoritesList(results.value!!)
    }
}