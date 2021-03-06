<<<<<<< HEAD
/* Copyright 2010-2013 SpringSource.
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

/**
 * @author <a href='mailto:burt@burtbeckwith.com'>Burt Beckwith</a>
 */

includeTargets << new File("$databaseMigrationPluginDir/scripts/_DatabaseMigrationCommon.groovy")

target(dbmDbDoc: 'Generates Javadoc-like documentation based on current database and change log') {
	depends dbmInit


	doAndClose {
		liquibase.generateDocumentation argsList[0] ?: MigrationUtils.getDbDocLocation(dsName), contexts
	}
}

setDefaultTarget dbmDbDoc
=======
/* Copyright 2010-2013 SpringSource.
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

/**
 * @author <a href='mailto:burt@burtbeckwith.com'>Burt Beckwith</a>
 */

includeTargets << new File("$databaseMigrationPluginDir/scripts/_DatabaseMigrationCommon.groovy")

target(dbmDbDoc: 'Generates Javadoc-like documentation based on current database and change log') {
	depends dbmInit


	doAndClose {
		liquibase.generateDocumentation argsList[0] ?: MigrationUtils.getDbDocLocation(dsName), contexts
	}
}

setDefaultTarget dbmDbDoc
>>>>>>> 365c3c9272a31ae581e4e78a977e8f5012d8d5af
