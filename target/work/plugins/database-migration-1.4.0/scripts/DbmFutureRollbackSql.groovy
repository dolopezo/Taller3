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

target(dbmFutureRollbackSql: 'Writes SQL to roll back the database to the current state after the changes in the changeslog have been applied') {
	depends dbmInit

	if (!okToWrite()) return

	doAndClose {
		liquibase.futureRollbackSQL contexts, ScriptUtils.newPrintWriter(argsList)
	}
}

setDefaultTarget dbmFutureRollbackSql
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

target(dbmFutureRollbackSql: 'Writes SQL to roll back the database to the current state after the changes in the changeslog have been applied') {
	depends dbmInit

	if (!okToWrite()) return

	doAndClose {
		liquibase.futureRollbackSQL contexts, ScriptUtils.newPrintWriter(argsList)
	}
}

setDefaultTarget dbmFutureRollbackSql
>>>>>>> 365c3c9272a31ae581e4e78a977e8f5012d8d5af
