/*
 * Copyright 2013-2014 Urs Wolfer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.urswolfer.gerrit.client.rest.http.changes;

import com.google.common.reflect.TypeToken;
import com.google.gerrit.extensions.common.FileInfo;
import com.google.gerrit.extensions.restapi.RestApiException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Thomas Forrer
 */
public class FileInfoParser {
    private static final Type TYPE = new TypeToken<LinkedHashMap<String, FileInfo>>() {}.getType();

    private final Gson gson;

    public FileInfoParser(Gson gson) {
        this.gson = gson;
    }

    public Map<String, FileInfo> parseFileInfos(JsonElement jsonElement) throws RestApiException {
        return gson.fromJson(jsonElement, TYPE);
    }
}
