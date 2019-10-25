from flask import Flask, request, render_template
app = Flask(__name__)
app.debug = True

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/predicted-videos', methods=['POST'])
def predict():
    try:
        user_input = request.form.get("user-input")
        
        response = {
                'status' : 'ok',
                'code' : 200,
                'result': [
                    {
                        'predicted_score': 97,
                        'user-input' : user_input
                    }
                ],
            }

        return render_template('success.html')

    except Exception as e:
        return 'Server is experiencing difficulties', 500
