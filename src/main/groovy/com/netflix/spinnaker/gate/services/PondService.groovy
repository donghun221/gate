/*
 * Copyright 2014 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.gate.services

import retrofit.http.Body
import retrofit.http.GET
import retrofit.http.Headers
import retrofit.http.POST
import retrofit.http.Path
import rx.Observable

interface PondService {

  @Headers("Accept: application/context+json")
  @POST("/ops")
  Observable<Map> doOperation(@Body Map<String, ? extends Object> body)

  @Headers("Accept: application/json")
  @GET("/applications/{application}/tasks")
  Observable<List> getTasks(@Path("application") String app)

  @Headers("Accept: application/json")
  @GET("/tasks/{id}")
  Observable<Map> getTask(@Path("id") String id)
}