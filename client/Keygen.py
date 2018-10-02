from Crypto.PublicKey import RSA

pathtokey = "prv_key.pem"
pathtopub = "pub_key.pem"

key = RSA.generate(2048)
with open(pathtokey, 'w') as content_file:
    content_file.write(key.exportKey('PEM').decode('UTF-8'))
pubkey = key.publickey()
with open(pathtopub, 'w') as content_file:
    content_file.write(pubkey.exportKey('OpenSSH').decode('UTF-8'))
