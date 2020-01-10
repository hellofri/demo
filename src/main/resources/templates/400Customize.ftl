package com.customize.${type};

import com.auto.${type}.${daoParentName};
<#if lombok == 1>
import lombok.Data;

@Data
</#if>
public ${classType} ${daoName} extends ${daoParentName} {
}