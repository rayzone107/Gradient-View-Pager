package com.rachitgoyal.gradientviewpagersample.ui.main

import android.os.Build
import android.os.Bundle
import android.text.Layout.JUSTIFICATION_MODE_INTER_WORD
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rachitgoyal.gradientviewpagersample.R
import com.rachitgoyal.gradientviewpagersample.model.Pasta

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setData(arguments?.getParcelable(ARG_PASTA) ?: Pasta())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        val textView: TextView = root.findViewById(R.id.tv_title)
        val descTextView: TextView = root.findViewById(R.id.tv_description)
        val imageView: ImageView = root.findViewById(R.id.iv_image)
        pageViewModel.text.observe(this, Observer<String> {
            textView.text = it
        })
        pageViewModel.desc.observe(this, Observer<String> {
            descTextView.text = it
        })
        pageViewModel.image.observe(this, Observer<Int> {
            imageView.setImageResource(it)
        })

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            descTextView.justificationMode = JUSTIFICATION_MODE_INTER_WORD
        }
        return root
    }

    companion object {
        private const val ARG_PASTA = "ARG_PASTA"

        @JvmStatic
        fun newInstance(pasta: Pasta): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PASTA, pasta)
                }
            }
        }
    }
}