#!/bin/bash
# The MIT License
# SPDX short identifier: MIT
# Further resources on the MIT License
# Copyright 2018 Amit Thakur - amitthk - <e.amitthakur@gmail.com>
# Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
# The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

if (($# <5))
  then
    echo "Usage : $0 <DOCKER_PROJECT_NAME> <APP_NAME> <IMAGE_TAG> <directory containing k8s files> <timestamp>"
    exit 1
fi

PROJECT_NAME=$1
APP_NAME=$2
IMAGE=$3
WORK_DIR=$4
TIMESTAMP=$5

main(){
find $WORK_DIR -name *.yml -type f -exec sed -i.bak1 's#__PROJECT_NAME__#'$PROJECT_NAME'#' {} \;
find $WORK_DIR -name *.yml -type f -exec sed -i.bak2 's#__APP_NAME__#'$APP_NAME'#' {} \;
find $WORK_DIR -name *.yml -type f -exec sed -i.bak3  's#__IMAGE__#'$IMAGE'#' {} \;
find $WORK_DIR -name *.yml -type f -exec sed -i.bak3  's#__TIMESTAMP__#'$TIMESTAMP'#' {} \;
}
main