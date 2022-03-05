package other.temparms.res.layout

fun mvvmListXml() = """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>

    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <com.scwang.smart.refresh.layout.SmartRefreshLayout
            android:id="@+id/rootRefresh"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent">
            <!--  列表数据  -->
            <androidx.recyclerview.widget.RecyclerView
                android:id="@+id/rootRecycler"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager" />
        </com.scwang.smart.refresh.layout.SmartRefreshLayout>
    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
    """