provider "aws" {
  region  = "ap-southeast-2"
  access_key = "AKIA2RO5HZZDUYZJL4O7"
  secret_key = "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"
}

resource "aws_vpc" "firstvpc" {
  cidr_block = "10.0.0.0/16"
  tags = {
    Name = "testvpc"
  }
}

resource "aws_subnet" "subnet1" {
  vpc_id     = aws_vpc.firstvpc.id
  cidr_block = "10.0.1.0/24"

  tags = {
    Name = "test-subnet"
  }
}



# resource "aws_instance" "my-ter-server" {
#   ami           = "ami-0f87b0a4eff45d9ce"
#   instance_type = "t2.micro"
#    tags = {
#     Name = "testubuntuserver"
#   }
# }