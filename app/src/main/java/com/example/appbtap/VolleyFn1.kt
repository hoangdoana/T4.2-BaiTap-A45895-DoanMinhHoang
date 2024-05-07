package com.example.appbtap

import android.content.Context
import android.widget.TextView
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class VolleyFn1 {
    var strJSON=""
    // ham doc du lieu tu API
    fun getAllData(context: Context, textView: TextView)
    {
        //1. Tao request
        val queue=Volley.newRequestQueue(context)
        //2. truyen url
        val url="https://hungnttg.github.io/array_json_new.json";
        //3. goi request
        // mang cua cac doi tuong -> goi mang truoc, doi tuong sau
        // JsonArrayRequest(url, thanh cong, that bai)
        val request=JsonArrayRequest(url, {response ->
             for (i in 0 until response.length() ){
                 try {
                     val person=response.getJSONObject(i)
                     val id=person.getString("id")
                     val name=person.getString("name")
                     val email=person.getString("email")
                     // dua tat ca vao chuoi
                     strJSON += "Id: $id\n";
                     strJSON += "Name: $name\n";
                     strJSON += "Email: $email\n";
                 }
                 catch(e: Exception){
                     e.printStackTrace();
                 }
             }
            textView.text=strJSON // hien thi ket qua len man hinh
        },{ error -> textView.text=error.message});
        //b4. thuc thi request
        queue.add(request)
    }
}