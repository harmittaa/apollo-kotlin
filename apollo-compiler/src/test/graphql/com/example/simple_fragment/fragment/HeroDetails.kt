// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.simple_fragment.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import kotlin.Array
import kotlin.String
import kotlin.Suppress

/**
 * A character from the Star Wars universe
 */
@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
internal interface HeroDetails : GraphqlFragment {
  val __typename: String

  /**
   * A humanoid creature from the Star Wars universe
   */
  data class HumanDetailsImpl(
    val humanDetailsDelegate: HumanDetails
  ) : DefaultImpl, HumanDetails by humanDetailsDelegate {
    companion object {
      operator fun invoke(reader: ResponseReader): HumanDetailsImpl {
        return HumanDetailsImpl(HumanDetails(reader))
      }
    }
  }

  /**
   * A character from the Star Wars universe
   */
  data class OtherDefaultImpl(
    override val __typename: String = "Character"
  ) : HeroDetails, DefaultImpl {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller.invoke { writer ->
        writer.writeString(RESPONSE_FIELDS[0], this@OtherDefaultImpl.__typename)
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null)
      )

      operator fun invoke(reader: ResponseReader): OtherDefaultImpl = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        OtherDefaultImpl(
          __typename = __typename
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<OtherDefaultImpl> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * A character from the Star Wars universe
   */
  interface DefaultImpl : HeroDetails {
    override val __typename: String

    fun asHumanDetails(): HumanDetails? = this as? HumanDetails

    override fun marshaller(): ResponseFieldMarshaller

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null)
      )

      operator fun invoke(reader: ResponseReader): DefaultImpl {
        val typename = reader.readString(RESPONSE_FIELDS[0])
        return when(typename) {
          "Human" -> HumanDetailsImpl(reader)
          else -> OtherDefaultImpl(reader)
        }
      }
    }
  }

  companion object {
    val FRAGMENT_DEFINITION: String = """
        |fragment HeroDetails on Character {
        |  __typename
        |  ... HumanDetails
        |}
        """.trimMargin()

    operator fun invoke(reader: ResponseReader): HeroDetails = DefaultImpl(reader)
  }
}
