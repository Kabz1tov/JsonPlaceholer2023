package kz.tutorial.jsonplaceholdertypicode.presentation.album_photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.constants.ALBUM_ID_KEY
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class AlbumPhotosFragment : Fragment() {

    private val vm: AlbumPhotosViewModel by viewModel {
        parametersOf(arguments?.getInt(ALBUM_ID_KEY, 0))
    }

    lateinit var rvPhotos: RecyclerView
    lateinit var tvAlbumName: TextView
    lateinit var tvAuthor: TextView
    lateinit var cbViewType: CheckBox

    lateinit var adapter: AlbumPhotosAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_album_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews(view)
        initAdapter()
        initRecycler()
        initObservers()
    }

    private fun initViews(view: View) {
        rvPhotos = view.findViewById(R.id.rv_photos)
        tvAlbumName = view.findViewById(R.id.tv_album_name)
        tvAuthor = view.findViewById(R.id.tv_author)
        cbViewType = view.findViewById(R.id.cb_view_type)

        cbViewType.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                rvPhotos.layoutManager = GridLayoutManager(activity, 2)
            } else {
                rvPhotos.layoutManager = LinearLayoutManager(activity)
            }
        }
    }

    private fun initAdapter() {
        adapter = AlbumPhotosAdapter(layoutInflater)
    }

    private fun initRecycler() {
        val currentContext = context ?: return

        rvPhotos.adapter = adapter
        rvPhotos.layoutManager = LinearLayoutManager(currentContext)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvPhotos.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        vm.albumDetailsLiveData.observe(viewLifecycleOwner) { album ->
            tvAlbumName.text = album.title
            tvAuthor.text = album.userId.toString()
        }
        vm.photosLiveData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }
}