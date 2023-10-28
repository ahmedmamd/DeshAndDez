package com.tmalty.data.models.core

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DepartmentWithServices(
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("services")
    @Expose
    var services: List<Service>? = listOf(Service(), Service(),Service(), Service(),Service(), Service(),)

)