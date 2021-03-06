/**
 * MIT License
 *
 * Copyright (c) 2017 zgqq
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mah.common.json.support.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import mah.common.json.AbstractJsonFactory;
import mah.common.json.JsonArr;
import mah.common.json.JsonFactory;
import mah.common.json.JsonObj;

import java.util.List;

/**
 * Created by zgq on 16-12-4.
 */
public class FastjsonJsonFactory extends AbstractJsonFactory implements JsonFactory {

    @Override
    public JsonObj parseObj(String content) {
        JSONObject jsonObject = JSON.parseObject(content);
        return JsonUtils.createJsonObj(jsonObject);
    }

    @Override
    public JsonArr parseArr(String content) {
        JSONArray jsonArray = JSON.parseArray(content);
        return JsonUtils.createJsonArr(jsonArray);
    }

    @Override
    public <T> List<T> parseArr(String text, Class<T> clazz) {
        return JSON.parseArray(text,clazz);
    }
}
