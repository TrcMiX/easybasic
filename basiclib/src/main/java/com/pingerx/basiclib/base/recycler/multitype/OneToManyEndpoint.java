package com.pingerx.basiclib.base.recycler.multitype;

import androidx.annotation.NonNull;

public interface OneToManyEndpoint<T> {

    void withLinker(@NonNull Linker<T> linker);

    void withClassLinker(@NonNull ClassLinker<T> classLinker);
}