package com.archer.gitdroid.hotrepo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.archer.gitdroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.header.StoreHouseHeader;

/**
 * Author: qixuefeng on 2016/7/27 0027.
 * E-mail: 377289596@qq.com
 */
public class RepoListFragment extends Fragment {

    @Bind(R.id.lvRepos)
    ListView lvRepos;
    @Bind(R.id.ptrClassicFrameLayout)
    PtrClassicFrameLayout ptrClassicFrameLayout;
    @Bind(R.id.emptyView)
    TextView emptyView;
    @Bind(R.id.errorView)
    TextView errorView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repo_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] a = {"hahahahah", "asdasda", "asdvrwevaerv", "asdvcwefvhsdv", "ddddddddddddddd"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, a);

        lvRepos.setAdapter(adapter);

        initPullToRefresh();

    }

    /**
     * 初始化下拉刷新
     */
    private void initPullToRefresh() {

        StoreHouseHeader header = new StoreHouseHeader(getContext());
        header.initWithString("I LIKE JAVA");
        header.setPadding(0, 60, 0, 60);

        ptrClassicFrameLayout.setHeaderView(header);
        ptrClassicFrameLayout.addPtrUIHandler(header);
        ptrClassicFrameLayout.setBackgroundResource(R.color.colorRefresh);

        //使用当前对象作为key，来记录下拉刷新的时间，如果两次刷新时间的间隔太短，就不刷新
        ptrClassicFrameLayout.setLastUpdateTimeRelateObject(this);
        //关闭header所时长
        ptrClassicFrameLayout.setDurationToCloseHeader(1500);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
