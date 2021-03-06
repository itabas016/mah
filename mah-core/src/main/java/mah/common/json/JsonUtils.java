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
package mah.common.json;

import mah.common.json.support.fastjson.FastjsonJsonFactory;
import mah.common.util.HttpUtils;
import mah.common.util.IoUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by zgq on 17-1-2 3:58.
 */
public class JsonUtils {
    private static final JsonFactory FACTORY = new FastjsonJsonFactory();

    private JsonUtils() {
    }

    public static JsonObj getJson(String url) {
        String content = HttpUtils.getContent(url);
        return FACTORY.parseObj(content);
    }

    public static <T> List<T> parseArrFromLocalFile(String file, Class<T> clazz) {
        try {
            String text = IoUtils.getStringByFilename(file);
            return FACTORY.parseArr(text, clazz);
        } catch (Exception e) {
            throw new JsonException(e);
        }
    }

    public static JsonArr parseArrFromLocalFile(String file) {
        try {
            String content = IoUtils.getStringByFilename(file);
            return parseArr(content);
        } catch (IOException e) {
            throw new JsonException(e);
        }
    }

    public JsonObj parseObjFromLocalFile(String file) {
        try {
            String content = IoUtils.getStringByFilename(file);
            return parseObj(content);
        } catch (IOException e) {
            throw new JsonException(e);
        }
    }

    private JsonObj parseObj(String text) {
        return FACTORY.parseObj(text);
    }

    public static <T> List<T> parseArr(String text, Class<T> clazz) {
        return FACTORY.parseArr(text, clazz);
    }

    public static JsonArr parseArr(String text) {
        return FACTORY.parseArr(text);
    }
}
