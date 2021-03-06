/*
 * Copyright 2020 Safeboda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.safeboda.data.local.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["login"], unique = true)])
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    val url: String,
    val avatarUrl: String,
    val bioHtml: String,
    val companyHtml: String,
    val email: String,
    val followersTotalCount: Int,
    val followingTotalCount: Int,
    val isDeveloperProgramMember: Boolean,
    val isVerified: Boolean,
    val isEmployee: Boolean,
    val isViewer: Boolean,
    val location: String,
    val login: String?,
    val name: String,
    val organizationsCount: Int,
    val repositoriesCount: Int,
    val starredRepositoriesCount: Int,
    val viewerCanFollow: Boolean,
    val viewerIsFollowing: Boolean,
    val websiteUrl: String,
    val isOrganization: Boolean,
    val emojiHtml: String,
    val indicatesLimitedAvailability: Boolean,
    val message: String
)