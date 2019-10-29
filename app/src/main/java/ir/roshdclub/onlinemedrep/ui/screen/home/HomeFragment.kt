package ir.roshdclub.onlinemedrep.ui.screen.home

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.roshdclub.onlinemedrep.R
import ir.roshdclub.onlinemedrep.ui.adapter.HomeRecyclerAdapter
import ir.roshdclub.onlinemedrep.ui.adapter.SearchRecyclerAdapter
import ir.roshdclub.onlinemedrep.ui.listener.HomeInteractionListener
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(){


    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeViewModelFactory: HomeViewModelFactory
   /* private lateinit var searchViewModel: SearchViewModel
    private lateinit var searchViewModelFactory: SearchViewModelFactory*/
    private var homeListener : HomeInteractionListener? = null
    private var searchListener : HomeInteractionListener? = null
    private var search: String = ""
    private lateinit var homeRecyclerView: RecyclerView
    private lateinit var searchRecyclerView: RecyclerView
    private lateinit var noResutlText: TextView

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModelFactory = HomeViewModelFactory(this.activity?.application!!)
        homeViewModel =
            ViewModelProviders.of(this, homeViewModelFactory).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val edtSearch: EditText = root.findViewById(R.id.edt_search)

        searchRecyclerView = root.findViewById(R.id.recycler_search)
        homeRecyclerView = root.findViewById(R.id.recycler_home)
        noResutlText = root.findViewById(R.id.txt_result)

        searchRecyclerView.layoutManager = LinearLayoutManager(context)
        homeRecyclerView.layoutManager =  GridLayoutManager(context,3)

        edtSearch.addTextChangedListener(object : TextWatcher{

            override fun afterTextChanged(tag: Editable?) {

                Handler().postDelayed({

                    if (tag?.length!! > 5){
                        search = tag.toString()
                        observersSearches()

                    } else {
                        searchRecyclerView.visibility = View.GONE
                        homeRecyclerView.visibility = View.VISIBLE
                        noResutlText.visibility = View.GONE

                    }
                },1000)

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

        })

        homeViewModel.list.observe(this, Observer {

            val x = it
            homeViewModel.image.observe(this, Observer {

                searchRecyclerView.visibility = View.GONE
                homeRecyclerView.visibility = View.VISIBLE
                noResutlText.visibility = View.GONE


                homeRecyclerView.adapter = HomeRecyclerAdapter(context, x, it,homeListener)

            })

        })


        return root
    }

    private fun observersSearches() {

        homeViewModel.tag.value = search

       homeViewModel.tag.observe(this, Observer {

           homeViewModel.getSearchResult(it).observe(this, Observer { it ->

               if (it.isNotEmpty()){

                    homeRecyclerView.visibility = View.GONE
                    searchRecyclerView.visibility = View.VISIBLE
                    noResutlText.visibility = View.GONE

                   val adapter = SearchRecyclerAdapter(context, searchListener)
                   recycler_search.adapter = adapter

                   it?.let { adapter.setWords(it) }

               } else {
                   homeRecyclerView.visibility = View.GONE
                   searchRecyclerView.visibility = View.GONE
                   noResutlText.visibility = View.VISIBLE

                   homeViewModel.result.observe(this, Observer {
                       noResutlText.text = it
                   })

               }
           })
       })
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)


        if (context is HomeInteractionListener ){
            searchListener = context
            homeListener = context


        }  else {
            throw RuntimeException(context.toString() + " must implement HomeInteraction") as Throwable

        }


    }

    override fun onDetach() {
        super.onDetach()
        searchListener = null
        homeListener = null
    }



}