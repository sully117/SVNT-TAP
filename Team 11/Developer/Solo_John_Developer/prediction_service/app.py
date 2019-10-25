from flask import Flask, request
app = Flask(__name__)

@app.route('/predicted-videos', methods=['POST'])
def predict():
    try:
        data = request.get_json()
        
        response = {
                'status' : 'ok',
                'code' : 200,
                'result': [
                    {
                        'predicted_score': 97,
                        'user-input' : data['user-input']
                    }
                ],
            }

        return response
    except Exception as e:
        return 'Server is experiencing difficulties', 500
